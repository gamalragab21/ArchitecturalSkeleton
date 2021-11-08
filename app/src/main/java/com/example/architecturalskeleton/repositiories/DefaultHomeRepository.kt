package com.example.architecturalskeleton.repositiories

import com.example.architecturalskeleton.qualifiers.IOThread
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultHomeRepository @Inject constructor(
//    private val apiJobService: ApiJobService,
//    private val jobDao: JobDao,
    @IOThread
    private val dispatcher: CoroutineDispatcher
) {

    // TODO: 11/8/2021 how to handle Dao or apiservice in repo  

//    suspend fun getListJob(currentJob: Int):Resource<ParentJob> = withContext(dispatcher){
//        safeCall {
//            val result=apiJobService.getListJobs(currentJob)
//            Resource.Success(result)
//        }
//    }
}