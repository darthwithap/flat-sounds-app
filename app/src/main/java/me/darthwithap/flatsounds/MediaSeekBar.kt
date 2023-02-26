package me.darthwithap.flatsounds

import android.content.Context
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar


class MediaSeekBar : AppCompatSeekBar {

    private var mediaController: MediaControllerCompat? = null
    private var mediaControllerCallback: ControllerCallback? = null
    var isTracking = false

    private val onSeekBarChangeListener: OnSeekBarChangeListener =
        object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                isTracking = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                mediaController?.transportControls?.seekTo(progress.toLong())
                isTracking = false
            }
        }

    constructor(context: Context?) : super(context!!) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context!!, attrs, defStyleAttr) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener)
    }

    override fun setOnSeekBarChangeListener(l: OnSeekBarChangeListener) {
        // Prohibit adding seek listeners to this subclass.
        throw UnsupportedOperationException("Cannot add listeners to a MediaSeekBar")
    }

    fun setMediaController(mediaController: MediaControllerCompat?) {
        // MediaController that is being passed will be set to the mediaControllerCallback
        mediaController?.let {
            mediaControllerCallback = ControllerCallback()
            it.registerCallback(mediaControllerCallback!!)
        } ?:
        // If already a MediaController exists, unregister the callback from the MediaController
        this.mediaController?.let {
            it.unregisterCallback(mediaControllerCallback!!)
            mediaControllerCallback = null
        }

        this.mediaController = mediaController
    }

    fun disconnectController() {
        mediaController?.let {
            it.unregisterCallback(mediaControllerCallback!!)
            mediaControllerCallback = null
            mediaController = null
        }
    }

    private inner class ControllerCallback : MediaControllerCompat.Callback() {
        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            super.onPlaybackStateChanged(state)

        }

        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            super.onMetadataChanged(metadata)
        }
    }

    companion object {
        private const val TAG = "MediaSeekBar"
    }
}