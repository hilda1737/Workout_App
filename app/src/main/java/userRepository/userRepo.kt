package userRepository

import com.getfit.workoutlog.API.APIclient
import com.getfit.workoutlog.API.ApiInterface
import com.getfit.workoutlog.Models.LoginResponse
import com.getfit.workoutlog.Models.Loginrequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class userRepo {
    val APIclientClient = APIclient.buildAPIclient(ApiInterface::class.java)

    suspend fun loginUser(loginrequest: Loginrequest): Response<LoginResponse>
            = withContext(Dispatchers.IO){
        val response = APIclient.loginUser(loginrequest)
        return@withContext response
    }
}
