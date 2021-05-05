package dev.rk3rn3r.website.rk3futuretheme

import com.eden.orchid.api.registration.OrchidModule
import com.eden.orchid.api.theme.Theme
import com.eden.orchid.utilities.addToSet

class RK3FutureModule : OrchidModule() {

    override fun configure() {
        addToSet<Theme, RK3FutureTheme>()
    }
}
