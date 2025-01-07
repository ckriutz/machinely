using Microsoft.AspNetCore.Mvc.RazorPages;
using System;

public class IndexModel : PageModel
{
    public string FamousScientist { get; private set; }

    public void OnGet()
    {
        var scientists = new[]
        {
            "Albert Einstein",
            "Isaac Newton",
            "Marie Curie",
            "Galileo Galilei",
            "Nikola Tesla"
        };

        var random = new Random();
        FamousScientist = scientists[random.Next(scientists.Length)];
    }
}
