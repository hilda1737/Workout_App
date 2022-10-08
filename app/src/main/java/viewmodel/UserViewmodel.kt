package viewmodel

import androidx.lifecycle.MutableLiveData
import com.getfit.workoutlog.Models.LoginResponse
import com.getfit.workoutlog.Models.Loginrequest
import kotlinx.coroutines.launch

class UserViewmodel {
        val userRepo = userRepository.userRepo()
        var registrationLiveData = MutableLiveData<LoginResponse>()
        val errorlivedData = MutableLiveData<String>()

        suspend fun loginUser(loginrequest: Loginrequest) {
            viewmodel.launch {
                val response = userRepo.loginUser(loginrequest)
                if (response.isSuccessful) {
                    registrationLiveData.postValue(response.body())
                } else {
                    errorlivedData.postValue(response.errorBody()?.string())
                }
            }
        }
    }