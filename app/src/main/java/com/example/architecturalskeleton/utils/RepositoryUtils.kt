package com.example.architecturalskeleton.utils

import com.example.architecturalskeleton.helpers.Resource


inline fun <T> safeCall(action: () -> Resource<T>): Resource<T> {
    return try {
        action()
    } catch(e: Exception) {
        Resource.Error(e.message ?: "An unknown error occurred")
    }
}


