package com.insyncwithfoo.pyrightls

import com.intellij.DynamicBundle
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.PropertyKey


private const val BUNDLE_PATH = "messages.pyrightls"


private object PyrightLSBundle : DynamicBundle(BUNDLE_PATH)


@Nls
internal fun message(
    @PropertyKey(resourceBundle = BUNDLE_PATH) key: String,
    vararg params: Any,
) =
    PyrightLSBundle.getMessage(key, *params)
