package com.example.asynctaskpractice

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asynctaskpractice.databinding.ActivityMainBinding
import java.sql.Time
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyAsyncTask().execute()

    }

    inner class MyAsyncTask : AsyncTask<Void, Void, Void>() {

        override fun onPreExecute() {
            super.onPreExecute()

            binding.tv.text = "Starting.."

        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)

            binding.tv.text = "Ending.."

        }

        override fun doInBackground(vararg p0: Void?): Void? {

            //1 - usul
            //Thread.sleep(2000)


            //2-usul
            try {

                for (i in 0..100) {

                    binding.progressBar.progress += 5
                    TimeUnit.SECONDS.sleep(2)

                }


            } catch (e: Exception) {

                e.printStackTrace()

            }

            return null

        }

    }

}