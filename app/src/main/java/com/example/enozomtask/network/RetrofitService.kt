
import com.example.enozomtask.Model
import com.google.gson.JsonObject
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @Headers(
        "x-api-key: BC_1dde28ce3c0d4792b7b4fd355fa80106_mETHadx+UZVoQgRg/wAIdfUNjysBiQ0rUjVuB1taQkw=",
        "Content-Type: application/json"
    )
    @GET("GetMyTask")
    suspend fun getText(): Model


    @Headers(
        "x-api-key: BC_1dde28ce3c0d4792b7b4fd355fa80106_mETHadx+UZVoQgRg/wAIdfUNjysBiQ0rUjVuB1taQkw=",
        "Content-Type: application/json"
    )
    @POST("SubmitResult")
    suspend fun postText(@Body requestBody: RequestBody): Response<JsonObject>
}