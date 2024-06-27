workspace "Bonfarto" {

    model {
        patient = person "Patient"
        doctor = person "Doctor"

        bonfarto = softwareSystem "Bonfarto" {

            webapp = container "Web application" "Web application" {
                tags "Web Application"
            }
            mobileApp = container "MobileApp" {
                tags "Mobile Application"
            }
            apiGateway = container "Api Gateway" {
                tags "Api Gateway"
            }

            patientService = group "Patient Service" {
                patientServiceApi = container "Patient Service API" {
                    tags "Patient Service" "Service API"
                }
                container "Patient Service Database" {
                    tags "Patient Service" "Database"
                    patientServiceApi -> this "Reads from and writes to"
                }
            }

            doctorService = group "Doctor Service" {
                doctorServiceApi = container "Doctor Service API" {
                    tags "Doctor Service" "Service API"
                }
                container "Doctor Service Database" {
                    tags "Doctor Service" "Database"
                    doctorServiceApi -> this "Reads from and writes to"
                }
            }

            appointmentService = group "Appointment Service" {
                appointmentServiceApi = container "Appointment Service API" {
                    tags "Appointment Service" "Service API"
                }
                container "Appointment Service Database" {
                    tags "Appointment Service" "Database"
                    appointmentServiceApi -> this "Reads from and writes to"
                }
            }

            billingService = group "Billing Service" {
                billingServiceApi = container "Billing Service API" {
                    tags "Billing Service" "Service API"
                }
                container "Billing Service Database" {
                    tags "Billing Service" "Database"
                    billingServiceApi -> this "Reads from and writes to"
                }
            }

            notificationService = group "Notification Service" {
                notificationServiceApi = container "Notification Service API" {
                    tags "Notification Service" "Service API"
                }
                container "Notification Service Database" {
                    tags "Notification Service" "Database"
                    notificationServiceApi -> this "Reads from and writes to"
                }
            }

            prescriptionService = group "Prescription Service" {
                prescriptionServiceApi = container "Prescription Service API" {
                    tags "Prescription Service" "Service API"
                }
                container "Prescription Service Database" {
                    tags "Prescription Service" "Database"
                    prescriptionServiceApi -> this "Reads from and writes to"
                }
            }


        }


        patient -> bonfarto "creates appointments, share health information"
        patient -> mobileApp "uses"
        patient -> webapp "uses"
        doctor -> bonfarto "review medical history"
        doctor -> mobileApp "uses"
        doctor -> webapp "uses"

        mobileApp -> apiGateway "sends requests"
        webapp -> apiGateway "sends requests"
        apiGateway -> patientServiceApi "forwards requests"
        apiGateway -> doctorServiceApi "forward requests"
        apiGateway -> appointmentServiceApi "forward requests"
        apiGateway -> billingServiceApi "forward requests"
        apiGateway -> notificationServiceApi "forward requests"
        apiGateway -> prescriptionServiceApi "forward requests"

    }




    views {

        systemContext bonfarto "SystemContext" {
            include *
            autolayout
            description "Context diagram"
        }

        container bonfarto "Containers" {
            include *
            autolayout
            description "Container diagram for Bonfarto"
        }

        styles {
            element "Software System" {
                background #1168bd
                color #ffffff
            }
            element "Person" {
                shape Person
                background #08427b
                color #ffffff
            }
            element "Api Gateway" {
                background #1168bd
                color #ffffff
            }
            element "Web Application" {
                background #1168bd
                color #ffffff
            }
            element "Mobile Application" {
                background #1168bd
                color #ffffff
            }
            element "Service API" {
                shape hexagon
            }
            element "Database" {
                shape cylinder
            }
            element "Doctor Service" {
                background #91F0AE
            }
            element "Patient Service" {
                background #EDF08C
            }

        }

    }

}