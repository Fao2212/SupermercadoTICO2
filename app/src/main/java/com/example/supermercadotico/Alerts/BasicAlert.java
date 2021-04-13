package com.example.supermercadotico.Alerts;

public abstract class BasicAlert{

    public static boolean alert(String text, AlertType alertType)
    {
        switch (alertType)
        {
            case OKAY:
                new OkayAlert(text);
                break;
            case QUESTION:
                return new QuestionAlert(text).question();
        }
        return false;
    }
}
