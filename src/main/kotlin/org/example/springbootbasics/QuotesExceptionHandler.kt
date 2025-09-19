package org.example.springbootbasics

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class QuotesExceptionHandler {

    @ExceptionHandler(QuoteNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onQuoteNotFound(e: QuoteNotFoundException) = mapOf(
        "errorCode" to "Quote not found",
        "message" to e.message
    )
}