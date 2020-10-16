package com.draco.nap

import android.service.quicksettings.TileService
import android.widget.Toast

class NapTileService: TileService() {
    override fun onClick() {
        super.onClick()
        val process = ProcessBuilder(
            "su", "-c",
            "sendevent /dev/input/event0 1 116 1 &&" + 
            "sendevent /dev/input/event0 0 0 0 &&" +
            "sendevent /dev/input/event0 1 116 0 &&" +
            "sendevent /dev/input/event0 0 0 0"
        ).start()
        process.waitFor()

        if (process.exitValue() != 0)
            Toast.makeText(this, "Failed to nap device. Check root permissions.", Toast.LENGTH_SHORT).show()
    }
}