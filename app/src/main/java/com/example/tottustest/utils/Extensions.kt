package com.example.tottustest.utils

import android.content.Context
import com.example.tottustest.R

fun Context.noDataError(): AppResult.Error {
    return AppResult.Error(Exception(this.resources.getString(R.string.error_no_data)))
}