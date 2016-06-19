<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> >
	<xsl:template match="/">
		<html>
  <body>
  <h2>My Sweet</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Name</th>
        <th>Energy</th>
        <th>Type</th>
        <th>Ingredients</th>
        <th>Values</th>
        <th>Prodaction</th>
      </tr>
      <xsl:for-each select="candy">
      <tr>
        <td><xsl:value-of select="name"/></td>
        <td><xsl:value-of select="energy/@amount"/> &#160;
        <xsl:value-of select="energy/@unit"/>
        </td>
        <td><xsl:value-of select="type"/></td>
        <td>
        <xsl:for-each select="ingredients/ingredient">
        <xsl:sort select="@amount" order="descending"/>
        <xsl:value-of select="@name"/>&#160;  
         <xsl:value-of select="@amount"/>
          <xsl:value-of select="@unit"/>;<br></br>
        </xsl:for-each>
        </td>
        <td>
        <xsl:for-each select="values/value">
        <xsl:value-of select="@name"/>&#160;  
         <xsl:value-of select="@amount"/>
          <xsl:value-of select="@unit"/>;<br></br>
        </xsl:for-each>
        </td>
        <td><xsl:value-of select="prodaction"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
	</xsl:template>
</xsl:stylesheet>