package com.insyncwithfoo.pyrightls

import com.intellij.codeInspection.ex.ExternalAnnotatorBatchInspection
import com.jetbrains.python.inspections.PyInspection


class PyrightLSInspection : PyInspection(), ExternalAnnotatorBatchInspection {
    
    override fun getShortName() = SHORT_NAME
    
    companion object {
        const val SHORT_NAME = "PyrightLSInspection"
    }
    
}
