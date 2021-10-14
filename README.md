# MybatisTypeHandler
Specify typeHandler for List&lt;T&gt; in mybatis.

|  typeHandler   | java type  | sql type  |
|  ----  | ----  | ----  |
| ListStringHandler  | List&lt;String&gt;  | varchar[]  |
| ListBigDecimalHandler  | List&lt;BigDecimal&gt;  | numeric[]  |
| ListBooleanHandler  | List&lt;Boolean&gt;  | bool[]  |
| ListDateHandler  | List&lt;Date&gt;  | date[]  |
| ListIntegerHandler  | List&lt;Integer&gt;  | integer[]  |

## Use
pom.xml
```xml
<dependency>
    <groupId>io.github.gaojizhou</groupId>
    <artifactId>MybatisTypeHandler</artifactId>
    <version>1.0.1</version>
</dependency>
```

Mybatis xml file

```xml
<select id="queryDog" resultMap="ResultMap">
    select id, name, coat_colors from dog
    where dog.id = any(#{ids,jdbcType=ARRAY,typeHandler=io.github.gaojizhou.ListStringHandler})
</select>

<resultMap id="ResultMap" type="io.github.gaojizhou.xxxxx.Dog">
    <id column="id" jdbcType="VARCHAR" property="id"/>
    <result column="name" jdbcType="VARCHAR" property="name"/>
    <result column="coat_colors"
            jdbcType="ARRAY"
            property="coatColors"
            typeHandler="io.github.gaojizhou.ListStringHandler"/>
</resultMap>
```
## License

See the [LICENSE](LICENSE.md) file for license rights and limitations (GPL-3.0 or later).
