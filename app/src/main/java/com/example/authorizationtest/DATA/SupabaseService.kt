import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.AuthConfig
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient

class SupabaseService {

    private val supabaseClient = createSupabaseClient(
        supabaseUrl = "https://znkfolyqntdbhmhpqcnq.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inpua2ZvbHlxbnRkYmhtaHBxY25xIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzExNDIyNzMsImV4cCI6MjA0NjcxODI3M30.5PkDtyJAGxL_7P6qviO_e_4WFhVerogxWaYfyUK0pn0"
    ) {
        install(Auth) {

        }
    }

    fun signIn(email: String, password: String, callback: (AuthConfig?) -> Unit) {
        supabaseClient.auth.signInWithEmail(email, password)
            .then { response ->
                callback(response)
            }
            .catch { error ->
                callback(null)
            }
    }

    fun signUp(email: String, password: String, callback: (AuthConfig?) -> Unit) {
        supabaseClient.auth.signUpWithEmail(email, password)
            .then { response ->
                callback(response)
            }
            .catch { error ->
                callback(null)
            }
    }

    fun getCurrentUser () = supabaseClient.auth.currentUserOrNull()
}
