FROM oracle/graalvm-ce:19.0.0 as graalvm
COPY . /home/app/micronautdemo2
WORKDIR /home/app/micronautdemo2
RUN gu install native-image
RUN native-image --no-server -cp build/libs/micronautdemo2-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronautdemo2 .
ENTRYPOINT ["./micronautdemo2"]
