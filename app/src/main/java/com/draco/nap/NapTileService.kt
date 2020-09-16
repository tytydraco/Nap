package com.draco.nap

import android.service.quicksettings.TileService
import android.widget.Toast

class NapTileService: TileService() {
    override fun onClick() {
        super.onClick()
        val process = ProcessBuilder("su", "-c", "input keyevent KEYCODE_POWER").start()
        process.waitFor()

        if (process.exitValue() != 0)
            Toast.makeText(this, "Failed to nap device. Check root permissions.", Toast.LENGTH_SHORT).show()
    }
}