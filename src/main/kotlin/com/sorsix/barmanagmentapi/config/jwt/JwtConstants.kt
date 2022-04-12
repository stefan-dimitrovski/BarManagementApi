package com.sorsix.barmanagmentapi.config.jwt

class JwtConstants {
    companion object {
        const val SECRET: String = "s3cr3tt0k3nsadasdashdvbasdhjadaksjfdasfhvh3cr3tt0k3ns" +
                "adasdashdvbasdhjadaksjfdasfhvh3cr3tt0k3nsadasdashdvb" +
                "asdhjadaksjfdasfhvh3cr3tt0k3nsadasdashdvbasdhjadaksjfdasfhvh"
        const val EXPIRATION_TIME: Int = 864_000_000 //10 days
        const val TOKEN_PREFIX: String = "Bearer "
        const val HEADER_STRING: String = "Authorization"
    }
}