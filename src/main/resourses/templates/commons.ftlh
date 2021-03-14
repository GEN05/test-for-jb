<#-- @ftlvariable name="user" type="jb.gusarov.test.domain.User" -->
<#-- @ftlvariable name="message" type="java.lang.String" -->
<#import "/spring.ftl" as spring/>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="icon" type="image/png" href="<@spring.url '/favicon.png'/>"/>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/normalize.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/form.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/datatable.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/article.css'/>">
        <script src="<@spring.url '/js/jquery-3.4.1.min.js'/>"></script>
        <script src="<@spring.url '/js/notify.js'/>"></script>
    </head>
    <body>
    <header>
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/users/all">Users</a></li>
                <li><a href="/addBook">Add book</a></li>
                <li><a href="/books">My books</a></li>
                <li><a href="/takeBook">Take book</a></li>
                <li><a href="/deleteBook">Delete book</a></li>
                <li><a href="/changeCipher">Change cipher</a></li>
            </ul>
            <ul>
                <li></li>
            </ul>
            <ul>
                <#if user??>
                    <li>${user.surname} ${user.name}</li>
                    <li><a href="/logout">Logout</a></li>
                <#else>
                    <li><a href="/enter">Enter</a></li>
                    <li><a href="/register">Register</a></li>
                </#if>
            </ul>
        </nav>
    </header>
    <div class="middle">
        <main>
            <#nested/>
        </main>
    </div>
    <footer>
        <a href="https://t.me/gen_05">Eugene Gusarov</a>
    </footer>
    </body>
    <script>
        <#--noinspection JSUnresolvedFunction-->
        $(function () {
            <#if message??>
            $.notify("${message?js_string}", {className: "success", position: "bottom right"});
            </#if>
        })
    </script>
    </html>
</#macro>

<#macro error field>
    <@spring.bind field/>
    <#if spring.status.errorMessage??>
        <div class="error">${spring.status.errorMessage}</div>
    </#if>
</#macro>

<#macro book book>
<#-- @ftlvariable name="book" type="jb.gusarov.test.domain.Book" -->
    <article>
        <div class="title"><a style="text-decoration: none; color:var(--caption-color)"
                              href="/book/${book.id?string}">${book.cipher}</a></div>
        <div class="information">By ${book.author}, ${book.creationTime}</div>
        <div class="body">${book.title}</div>
        <div class="users">
            <#list book.users as user>
                <p>${user.surname}</p>
            </#list>
        </div>
    </article>
</#macro>