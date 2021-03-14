<#-- @ftlvariable name="books" type="jb.gusarov.test.domain.Book[]" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if books?size==0>
        No data
    <#else>
        <tbody>
        <#list books as book>
            <@c.book book=book/>
        </#list>
        </tbody>
    </#if>
</@c.page>