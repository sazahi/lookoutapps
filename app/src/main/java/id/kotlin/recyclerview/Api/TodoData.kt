package id.kotlin.recyclerview.Api

data class TodoData (
    val username: String,
    val description: String? = null,
    val done_at: String? = null,
    val session_id: String? = null,
)