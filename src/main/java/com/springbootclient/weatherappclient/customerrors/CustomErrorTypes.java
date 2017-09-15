package com.springbootclient.weatherappclient.customerrors;

public class CustomErrorTypes
{
       private String errorMessage;

       public CustomErrorTypes(String errorMessage)
       {
           this.errorMessage = errorMessage;
       }

       public String getErrorMessage()
       {
            return errorMessage;
       }

    }
