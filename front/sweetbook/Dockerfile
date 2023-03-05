FROM node:alpine
WORKDIR /app
COPY ./front/sweetbook /app/
RUN npm install
CMD [ "npm", "start" ]
EXPOSE 3000