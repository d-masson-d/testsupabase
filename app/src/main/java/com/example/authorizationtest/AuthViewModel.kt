import androidx.lifecycle.ViewModel
import io.github.jan.supabase.auth.AuthConfig

class AuthViewModel : ViewModel() {
    private val supabaseService = SupabaseService()
    fun signIn(email: String, password: String, callback: (AuthConfig?) -> Unit) {
        supabaseService.signIn(email, password, callback)
    }
    fun signUp(email: String, password: String, callback: (AuthConfig?) -> Unit) {
        supabaseService.signUp(email, password, callback)
    }
    fun getCurrentUser () = supabaseService.getCurrentUser ()
}
