const express = require('express');
const promoRouter = express.Router();
const bodyParser = require('body-parser');

promoRouter.use(bodyParser.json());
promoRouter.route('/').
  get((req, res, next) => {
    res.end('Will send all the promotions to you')
  })
  .post((req, res, next) => {
    res.statusCode = 403;
    res.end('POST operation not supported on /promotions/ ' + req.params.promoId)
  })
  .put((req, res, next) => {
    res.write('Updating the promo: ' + req.params.promoId + '\n');
    res.end('will update the promo' + req.body.name + 'with details: ' + req.body.description);
  })
  .delete((req, res, next) => {
    res.end('Delete all promotions');
  });

promoRouter.route('/:promoId')
  .get((req, res, next) => {
    res.end('Will send details of the promo ' + req.params.promoId + ' to you');
  })
  .post((req, res, next) => {
    res.statusCode = 403;
    res.end('POST operation not supported on /promotions/' + req.params.promoId)
  })
  .put((req, res, next) => {
    res.write('Updating the promo: ' + req.params.promoId + '\n');
    res.end('will update the promo' + req.body.name + 'with details: ' + req.body.description);
  })
  .delete((req, res, next) => {
    res.end('Deleting promo:' + req.params.promoId);
  });
module.exports = promoRouter