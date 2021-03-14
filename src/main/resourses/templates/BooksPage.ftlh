<#import "commons.ftlh" as c>

<@c.page>
    <#list user.books as book>
        <@c.book book=book/>
    </#list>
    <#if user.books?size == 0>
        You haven't your own posts on Codeforces.
    </#if>
</@c.page>