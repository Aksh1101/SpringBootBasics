package org.example.springbootbasics

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/quotes")
class QuoteController {

    val quotes = mutableListOf<QuotesDto>()

//    @GetMapping
//    fun loadQuotes(): List<QuotesDto> {
//        return quotes
//    }
    @GetMapping
    fun loadQuotes(
    @RequestParam(value = "q", required = false) query: String?,
    ): List<QuotesDto> {
        return if (query != null) {
            quotes.filter {
                it.content.contains(query , ignoreCase = true)
            }
        } else quotes
    }

    @PostMapping
    fun postQuotes(
        @RequestBody quotesDto: QuotesDto
    ) : QuotesDto {
        quotes.add(quotesDto)
        return quotesDto
    }

    @PutMapping
    fun putQuotes(
        @RequestBody quotesDto: QuotesDto
    ) : QuotesDto {
        val index = quotes.indexOfFirst { it.id == quotesDto.id }
        quotes[index] = quotesDto

        return quotesDto
    }

    @DeleteMapping("/{id}")
    fun deleteQuotes(
        @PathVariable("id") id: Long
    ) : ResponseEntity<Void> {
        val quoteToDelete  = quotes.find { it.id == id }
        return if (quoteToDelete != null) {
            quotes.remove(quoteToDelete)

            ResponseEntity.ok().build()

        }else{
            //throw ResponseStatusException(HttpStatus.NOT_FOUND)
            //ResponseEntity.status(HttpStatus.NOT_FOUND).build()
            throw QuoteNotFoundException(id)

        }
    }


}