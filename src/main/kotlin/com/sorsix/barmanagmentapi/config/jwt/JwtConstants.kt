package com.sorsix.barmanagmentapi.config.jwt

class JwtConstants {
    companion object {
        const val SECRET = "s3cr3tt0k3nsadasdashdvbasdhjadaksjfdasfhvh3cr3tt0k3ns" +
                "adasdashdvbasdhjadaksjfdasfhvh3cr3tt0k3nsadasdashdvb" +
                "asdhjadaksjfdasfhvh3cr3tt0k3nsadasdashdvbasdhjadaksjfdasfhvh"
        const val EXPIRATION_TIME: Long = 86400000L //1 day
        const val TOKEN_PREFIX = "Bearer "
        const val HEADER_STRING = "Authorization"
    }
}