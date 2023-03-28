package com.example.xcompanyassignment.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class IOScheduler