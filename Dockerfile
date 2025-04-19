FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .

# ✅ Fix permission for mvnw
RUN chmod +x mvnw

# ✅ Build the app
RUN ./mvnw clean package -DskipTests

# ✅ Run the app
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
