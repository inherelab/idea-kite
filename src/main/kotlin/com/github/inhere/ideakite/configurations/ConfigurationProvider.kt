package com.github.inhere.ideakite.configurations

import java.io.File

interface ConfigurationProvider {
    fun subscribe(updateSubscription: (Sequence<File>) -> Unit)
    fun unsubscribe()
}