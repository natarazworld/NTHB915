<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


      <c:choose>
         <c:when test="${!empty dto}">
         <b> The product details are:: </b>
           <table border="1" align="center" bgcolor="pink">
               <tr>
                 <td>${dto.policyId}  </td>
                 <td>${dto.policyName}  </td>
                 <td>${dto.company} </td>
                 <td>${dto.tenure} </td>
               </tr>
           </table>         
         </c:when>
         <c:otherwise>
              <h1 style="color:red;text-align:center">Product not found</h1>
         </c:otherwise>
      </c:choose>
 <br><br>
  <a href="form.html">home</a>