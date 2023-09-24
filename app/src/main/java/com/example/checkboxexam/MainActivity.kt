package com.example.checkboxexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.checkboxexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isAllSelected = false
    private var isFirstSelected = false
    private var isSecondSelected = false
    private var isThreeSelected = false
    private var isFourSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkClickState()
    }

    private fun checkClickState() {
        // 전체 동의 LinearLayout 클릭 시 checkbox가 check되는 클릭 리스너 설정
        binding.allCheckLL.setOnClickListener {
            val isChecked = !binding.allCheckBox.isChecked
            binding.allCheckBox.isChecked = isChecked
            binding.firstCheckBox.isChecked = isChecked
            binding.secondCheckBox.isChecked = isChecked
            binding.threeCheckBox.isChecked = isChecked
            binding.fourCheckBox.isChecked = isChecked
            binding.nextButton.isEnabled = isChecked
            isAllSelected = isChecked
            isFirstSelected = isChecked
            isSecondSelected = isChecked
            isThreeSelected = isChecked
            isFourSelected = isChecked

            allCheckState()
            firstCheckState()
            secondCheckState()
            threeCheckState()
            fourCheckState()
        }

        binding.firstCheckLL.setOnClickListener {
            binding.firstCheckBox.isChecked = !binding.firstCheckBox.isChecked
            isFirstSelected = binding.firstCheckBox.isChecked
            firstCheckState()
            updateButtonState()
        }

        binding.secondCheckLL.setOnClickListener {
            binding.secondCheckBox.isChecked = !binding.secondCheckBox.isChecked
            isSecondSelected = binding.secondCheckBox.isChecked
            secondCheckState()
            updateButtonState()
        }

        binding.threeCheckLL.setOnClickListener {
            binding.threeCheckBox.isChecked = !binding.threeCheckBox.isChecked
            isThreeSelected = binding.threeCheckBox.isChecked
            threeCheckState()
            updateButtonState()
        }

        binding.fourCheckLL.setOnClickListener {
            binding.fourCheckBox.isChecked = !binding.fourCheckBox.isChecked
            isFourSelected = binding.fourCheckBox.isChecked
            fourCheckState()
            updateButtonState()
        }
    }

    private fun updateButtonState() {
        val mushSelected = isFirstSelected && isSecondSelected && isThreeSelected
        if (mushSelected) {
            binding.nextButton.isEnabled = true
        }

        val fourSelected = isFirstSelected && isSecondSelected && isThreeSelected && isFourSelected
        if (fourSelected) {
            binding.allCheckBox.isChecked = isFourSelected
            allCheckState()
            binding.nextButton.isEnabled = isFourSelected
        } else if (mushSelected) {
            // 필수 동의만 선택되었을 때
            binding.allCheckBox.isChecked = false
            allCheckState()
        }
    }

    private fun allCheckState() {
        if (binding.allCheckBox.isChecked) {
            enabledAgreeText(binding.allCheckTV, binding.allAgreeTV)
        } else {
            disEnabledAgreeText(binding.allCheckTV, binding.allAgreeTV)
        }
    }

    private fun firstCheckState() {
        if (binding.firstCheckBox.isChecked) {
            enabledAgreeText(binding.firstCheckTV, binding.firstAgreeTV)
        } else {
            disEnabledAgreeText(binding.firstCheckTV, binding.firstAgreeTV)
        }
    }

    private fun secondCheckState() {
        if (binding.secondCheckBox.isChecked) {
            enabledAgreeText(binding.secondCheckTV, binding.secondAgreeTV)
        } else {
            disEnabledAgreeText(binding.secondCheckTV, binding.secondAgreeTV)
        }
    }

    private fun threeCheckState() {
        if (binding.threeCheckBox.isChecked ) {
            enabledAgreeText(binding.threeCheckTV, binding.threeAgreeTV)
        } else {
            disEnabledAgreeText(binding.threeCheckTV, binding.threeAgreeTV)
        }
    }

    private fun fourCheckState() {
        if (binding.fourCheckBox.isChecked) {
            enabledAgreeText(binding.fourCheckTV, binding.fourAgreeTV)
        } else {
            disEnabledAgreeText(binding.fourCheckTV, binding.fourAgreeTV)
        }
    }

    private fun enabledAgreeText(textView: TextView, agreeText: TextView) {
        textView.setTextColor(ContextCompat.getColor(this, R.color.skyblue))
        agreeText.setTextColor(ContextCompat.getColor(this, R.color.skyblue))
    }

    private fun disEnabledAgreeText(textView: TextView, agreeText: TextView) {
        textView.setTextColor(ContextCompat.getColor(this, R.color.black))
        agreeText.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
}