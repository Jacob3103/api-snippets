// Download the twilio-csharp library from twilio.com/docs/libraries/csharp
using System;
using Twilio;
using Twilio.Rest.Sync.V1.Service.SyncMap;

public class Example
{
    public static void Main(string[] args)
    {
        // Find your Account SID and Auth Token at twilio.com/console
        // To set up environmental variables, see http://twil.io/secure
        const string accountSid = Environment.GetEnvironmentVariable("TWILIO_ACCOUNT_SID");
        const string authToken = Environment.GetEnvironmentVariable("TWILIO_AUTH_TOKEN");
        const string serviceSid = Environment.GetEnvironmentVariable("TWILIO_SERVICE_SID");

        TwilioClient.Init(accountSid, authToken);

        var items = SyncMapItemResource.Read(
            serviceSid,
            "Players",
            from: "steph_curry",
            order: SyncMapItemResource.QueryResultOrderEnum.Asc);

        foreach (var item in items)
        {
            Console.WriteLine($"{item.Key} = {item.Data}");
        }
    }
}
