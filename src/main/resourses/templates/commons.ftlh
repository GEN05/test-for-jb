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
                <#--                <#if user??>-->
                <li><a href="/addBook">Add book</a></li>
                <li><a href="/books">Books</a></li>
                <#--                </#if>-->
            </ul>
            <ul>
                <li></li>
            </ul>
            <ul>
                <#if user??>
                <li>${user.name}</li>
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
                              href="/book/${book.id?string}">${book.title}</a></div>
        <div class="information">By ${book.users.name}, ${book.creationTime}</div>
        <div class="body">${book.author}</div>
        <ul class="attachment">
            <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>
            <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>
        </ul>
        <div class="footer">
            <div class="left">
                <img src="<@spring.url '/img/voteup.png'/>" title="Vote Up" alt="Vote Up"/>
                <span class="positive-score">+173</span>
                <img src="<@spring.url '/img/votedown.png'/>" title="Vote Down" alt="Vote Down"/>
            </div>
            <div class="right">
                <img src="<@spring.url '/img/date_16x16.png'/>" title="Publish Time" alt="Publish Time"/>
                ${book.creationTime}
                <img src="<@spring.url '/img/comments_16x16.png'/>" title="Comments" alt="Comments"/>
                <a href="/post/${book.id}">${book.author}</a>
            </div>
        </div>
    </article>
</#macro>