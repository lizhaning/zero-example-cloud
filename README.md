# zero-example-cloud

尚硅谷 SpringCloud (H&Alibaba)版学习示例

<springboot.version>2.2.7.RELEASE</springboot.version>

<spring.cloud-version>Hoxton.SR8</spring.cloud-version>

<aliyun.cloud-version>2.2.1.RELEASE</aliyun.cloud-version>

<dependencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>${springboot.version}</version>
      <type>pom</type>
      <scope>import</scope>
  </dependency>
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>${spring.cloud-version}</version>
      <type>pom</type>
      <scope>import</scope>
  </dependency>
  <dependency>
      <groupId>com.alibaba.cloud</groupId>
      <artifactId>spring-cloud-alibaba-dependencies</artifactId>
      <version>${aliyun.cloud-version}</version>
      <type>pom</type>
      <scope>import</scope>
  </dependency>
</dependencies>
