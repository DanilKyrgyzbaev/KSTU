package kg.kstu.kstu.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.kstu.kstu.databinding.ActivityAuthLandingBinding
import kg.kstu.kstu.ui.MainActivity

class AuthLandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val login = binding.loginText.text
        val password = binding.passwordText.text
        binding.next.setOnClickListener {
            if (login.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "ввдетите пароль или логин", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
