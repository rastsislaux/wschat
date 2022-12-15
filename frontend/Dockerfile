FROM node:19-alpine
WORKDIR app/
COPY . .
RUN npm install
RUN npm i -g @angular/cli
EXPOSE 4200
ENTRYPOINT ["ng", "serve", "--host", "0.0.0.0"]
