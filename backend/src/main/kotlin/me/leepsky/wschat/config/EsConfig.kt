package me.leepsky.wschat.config

import co.elastic.clients.elasticsearch.ElasticsearchClient
import co.elastic.clients.json.jackson.JacksonJsonpMapper
import co.elastic.clients.transport.ElasticsearchTransport
import co.elastic.clients.transport.rest_client.RestClientTransport
import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["me.leepsky.wschat.repository"])
@ComponentScan(basePackages = ["me.leepsky.wschat.config"])
class EsConfig {

    @Value("\${app.elasticsearch.hostname}")
    lateinit var esHostname: String;

    @Value("\${app.elasticsearch.port}")
    lateinit var esPort: Integer;

    @Bean
    fun restClient(): RestClient {
        return RestClient.builder(HttpHost(esHostname, esPort.toInt())).build()
    }

    @Bean
    fun transport(restClient: RestClient): ElasticsearchTransport {
        return RestClientTransport(restClient, JacksonJsonpMapper())
    }

    @Bean
    fun client(transport: ElasticsearchTransport): ElasticsearchClient {
        return ElasticsearchClient(transport)
    }

}