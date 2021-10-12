# MybatisTypeHandler
Specify typeHandler for List&lt;String&gt; in mybatis

## Install
```shell
git clone https://github.com/gaojizhou/MybatisTypeHandler.git
cd MybatisTypeHandler
mvn install
```

## Use
pom.xml
```xml
<dependency>
    <groupId>com.github.gaojizhou</groupId>
    <artifactId>MybatisTypeHandler</artifactId>
    <version>0.0.1</version>
</dependency>
```

Mybatis xml file
```xml
<select id="queryHomeworkId"  resultMap="ResultMap">
select id, name, coat_colors from dog
where dog.id = any(#{ids,jdbcType=ARRAY,typeHandler=com.github.gaojizhou.ListObjectHandler})
</select>

<resultMap id="ResultMap" type="com.github.gaojizhou.xxxxx.Dog">
    <id column="id" jdbcType="VARCHAR" property="id"/>
    <result column="name" jdbcType="VARCHAR" property="name"/>
    <result column="coat_colors"
            jdbcType="ARRAY"
            property="coatColors"
            typeHandler="com.github.gaojizhou.ListObjectHandler"/>
</resultMap>
```