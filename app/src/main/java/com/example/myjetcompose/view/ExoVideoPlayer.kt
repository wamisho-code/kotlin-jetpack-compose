package com.example.myjetcompose.view

import android.content.Context
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.example.myjetcompose.R

@OptIn(UnstableApi::class)
@Composable
fun ExoPlayerScreen(context: Context, exoPlayer: ExoPlayer, lifecycle: Lifecycle.Event){
    AndroidView(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .aspectRatio(16f/9f)
            .clip(RoundedCornerShape(20.dp)),

        factory = { ctx ->
            PlayerView(ctx).also { playerView ->
                playerView.player = exoPlayer
                playerView.useController = true

                // FIXED: Explicitly set controls to auto-hide after 3000 milliseconds (3 seconds)
                playerView.controllerShowTimeoutMs = 2000
                playerView.setShowRewindButton(true)
                playerView.setShowFastForwardButton(true)


                // Keeps the background clean and honors Compose clipping boundaries
                playerView.setShutterBackgroundColor(android.graphics.Color.TRANSPARENT)

            }
        },
        update = {
            when(lifecycle){
                Lifecycle.Event.ON_RESUME -> {
                    it.onResume()
                    it.player?.play()
                }
                Lifecycle.Event.ON_PAUSE -> {
                    it.onPause()
                    it.player?.pause()
                }
                else -> Unit
            }
        }
    )
}

@OptIn(UnstableApi::class)
@Composable
fun Player(){
    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }
    val context= LocalContext.current
    val onlineVideo = "https://cms-public-artifacts.motionarray.com/content/motion-array/1235936/PRD-1235936-cnTQdksszIWPjIbR-original_playlist_1706744997.m3u8"
    val localVideo="android.resource://${context.packageName}/${R.raw.coke_video}"
    val mediaItem= MediaItem.fromUri(onlineVideo)
    val mediaSource: MediaSource= ProgressiveMediaSource
        .Factory(DefaultHttpDataSource.Factory())
        .createMediaSource(mediaItem)
    val exoplayer = remember {
        ExoPlayer.Builder(context)
            .build().apply{
                setMediaItem(mediaItem)
                prepare()
                playWhenReady=false
            }
    }
    val lifecycleOwner= LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver{_,event ->
            lifecycle=event

        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            exoplayer.release()
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    ExoPlayerScreen(context,exoplayer,lifecycle)
}