package oldgrails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"main",view:"/main/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
