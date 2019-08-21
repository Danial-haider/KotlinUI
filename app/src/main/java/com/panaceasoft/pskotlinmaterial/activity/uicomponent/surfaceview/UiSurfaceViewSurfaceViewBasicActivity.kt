package com.panaceasoft.pskotlinmaterial.activity.uicomponent.surfaceview


import android.Manifest.permission.*
import android.content.pm.PackageManager
import android.graphics.*
import android.hardware.Camera
import android.media.ExifInterface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.panaceasoft.pskotlinmaterial.R
import kotlinx.android.synthetic.main.ui_surface_view_surface_view_basic_activity.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


@Suppress("DEPRECATION")
class UiSurfaceViewSurfaceViewBasicActivity : AppCompatActivity(), SurfaceHolder.Callback {

    internal lateinit var camera: Camera
    internal lateinit var camView: SurfaceView
    internal lateinit var surfaceHolder: SurfaceHolder
    internal var camCondition = false
    internal lateinit var captureButton: Button
    internal var filePath = "/sdcard/PS_"


    private var mPictureCallback = Camera.PictureCallback { data, camera ->
        val outputFileName = filePath + System.currentTimeMillis() + ".jpg"

        val pictureFile = File(outputFileName)
        if (pictureFile.exists()) {
            pictureFile.delete()
        }

        try {
            val fos = FileOutputStream(outputFileName)

            var realImage = BitmapFactory.decodeByteArray(data, 0, data!!.size)

            val exif = ExifInterface(pictureFile.toString())

            Log.d("EXIF value", exif.getAttribute(ExifInterface.TAG_ORIENTATION))
            if (exif.getAttribute(ExifInterface.TAG_ORIENTATION).equals("6", ignoreCase = true)) {
                realImage = rotate(realImage, 90)
            } else if (exif.getAttribute(ExifInterface.TAG_ORIENTATION).equals("8", ignoreCase = true)) {
                realImage = rotate(realImage, 270)
            } else if (exif.getAttribute(ExifInterface.TAG_ORIENTATION).equals("3", ignoreCase = true)) {
                realImage = rotate(realImage, 180)
            } else if (exif.getAttribute(ExifInterface.TAG_ORIENTATION).equals("0", ignoreCase = true)) {
                realImage = rotate(realImage, 90)
            }

            val bo = realImage.compress(Bitmap.CompressFormat.JPEG, 100, fos)

            fos.close()

            Log.d("Info", bo.toString() + "")

        } catch (e: FileNotFoundException) {
            Log.d("Info", "File not found: " + e.message)
        } catch (e: IOException) {
            Log.d("TAG", "Error accessing file: " + e.message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_surface_view_surface_view_basic_activity)

        initToolbar()

        window.setFormat(PixelFormat.UNKNOWN)

        val currentapiVersion = android.os.Build.VERSION.SDK_INT
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) {
                Toast.makeText(applicationContext, "Permission already granted", Toast.LENGTH_LONG).show()
            } else {
                requestPermission()
            }
        }

        camView = findViewById(R.id.surfaceView)
        captureButton = findViewById(R.id.captureButton)


        surfaceHolder = camView.holder
        surfaceHolder.addCallback(this)

        // click event on button
        captureButton.setOnClickListener {
            try {
                camera.takePicture(null, null, mPictureCallback)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        eff1Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_NONE) }


        eff2Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_BLACKBOARD) }


        eff3Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_MONO) }


        eff4Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_NEGATIVE) }


        eff5Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_POSTERIZE) }


        eff6Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_SEPIA) }


        eff7Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_SOLARIZE) }


        eff8Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_WHITEBOARD) }


        eff9Button.setOnClickListener {  setCameraParameter(Camera.Parameters.EFFECT_AQUA) }

    }


    private fun setCameraParameter(effect: String) {
        // condition to check whether your device have camera or not

        try {
            val parameters = camera.parameters
            parameters.colorEffect = effect //applying effect on camera
            camera.parameters = parameters
            camera.setPreviewDisplay(surfaceHolder)
            camera.startPreview()

            camCondition = true
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    //region Init Toolbar
    private fun initToolbar() {

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_24)

        if (toolbar.navigationIcon != null) {
            toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(this, R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)
        }

        toolbar.title = "Basic SurfaceView"

        try {
          toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.md_white_1000))
        } catch (e: Exception) {
            Log.e("TEAMPS", "Can't set color.")
        }

        try {
            setSupportActionBar(toolbar)
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set support action bar.")
        }

        try {
            if (supportActionBar != null) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        } catch (e: Exception) {
            Log.e("TEAMPS", "Error in set display home as up enabled.")
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int,
                                height: Int) {

        try {
            // stop the camera
            if (camCondition) {
                camera.stopPreview()
                camCondition = false
            }

            setCameraParameter(Camera.Parameters.EFFECT_SEPIA)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    override fun surfaceCreated(holder: SurfaceHolder) {

        try {
            camera = Camera.open()
            camera.setDisplayOrientation(90)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

        try {
            camera.stopPreview()
            camera.release()
//            camera = null
            camCondition = false
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(applicationContext, GET_ACCOUNTS)
        val result1 = ContextCompat.checkSelfPermission(applicationContext, CAMERA)
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(GET_ACCOUNTS, CAMERA), REQUEST_GET_ACCOUNT)
        ActivityCompat.requestPermissions(this, arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> if (grantResults.size > 0) {

                val locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if (locationAccepted && cameraAccepted) {
                    Toast.makeText(applicationContext, "Permission Granted, Now you can access location data and camera", Toast.LENGTH_LONG).show()
                    surfaceHolder = camView.holder
                    surfaceHolder.addCallback(this)
                } else {
                    Toast.makeText(applicationContext, "Permission Denied, You cannot access location data and camera", Toast.LENGTH_LONG).show()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                            showMessageOKCancel("You need to allow access to both the permissions"
                            ) { _, _ ->
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    requestPermissions(arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
                                            PERMISSION_REQUEST_CODE)
                                }
                            }
                            return
                        }
                    }

                }
            }
        }
    }

    private fun showMessageOKCancel(message: String, okListener: (Any, Any) -> Unit) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show()
    }

    companion object {

        private val REQUEST_GET_ACCOUNT = 112
        private val PERMISSION_REQUEST_CODE = 200

        fun rotate(bitmap: Bitmap, degree: Int): Bitmap {
            val w = bitmap.width
            val h = bitmap.height

            val mtx = Matrix()
            mtx.setRotate(degree.toFloat())

            return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true)
        }
    }
}
