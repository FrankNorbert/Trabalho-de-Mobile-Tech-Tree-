package Trabalho.Mobile.PartPicker

import Trabalho.Mobile.PartPicker.Fragments.CpuFragment
import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PartPickerActivity : AppCompatActivity() {

    lateinit var cpuButton: Button
    lateinit var gpuButton: Button
    lateinit var fragmentView : FrameLayout

    companion object{
        const val TAG = "PartPickerActivity"
    }

    val cpuFragment = CpuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_picker)

        cpuButton = findViewById(R.id.picker_cpu)
        gpuButton = findViewById(R.id.picker_gpu)
        /*
        fragmentView = findViewById(R.id.picker_fragment_display)

        cpuButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.picker_fragment_display,cpuFragment)
                commit()
            }
        }
         */

        cpuButton.setOnClickListener{
            startActivity(Intent(this@PartPickerActivity,CpuSelectorActivity::class.java))
        }

        gpuButton.setOnClickListener{
            startActivity(Intent(this@PartPickerActivity,GpuSelectorActivity::class.java))
        }
    }
}