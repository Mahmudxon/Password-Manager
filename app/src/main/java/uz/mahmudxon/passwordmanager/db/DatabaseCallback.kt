package uz.mahmudxon.passwordmanager.db

interface DatabaseCallback {

    fun onDatabaseError(error: Throwable)

    fun onCompletableComplete()

    fun onQueryWithAnswer(data : Any?)

}