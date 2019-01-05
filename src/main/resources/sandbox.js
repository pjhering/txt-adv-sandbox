
function execute(model, args, response)
{
    for(var i = 0; i < args.length; i++)
    {
        java.lang.System.out.println(args[i]);
    }
    
    java.lang.System.out.println(model.title);
    java.lang.System.out.println(model.author);
    
    response.add('hello');
    response.add('world');
}
