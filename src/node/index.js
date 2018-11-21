const options = { method: 'POST',
  port: 8080,
  headers: {
    'content-type': 'application/stream+json'
  }
};
const req = require('http').request(options, function (res) {
  res.on('data', function (chunk) {
    console.log('BODY: ' + chunk);
  });
});

req.on('error', function (e) {
  console.log('problem with request: ' + e.message);
});

const rand = () => (
  Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15)
);

// write data to request body
for (let id=0; id < 100; id++) {
  let message = rand();
  req.write(JSON.stringify({ id, message }));
}
req.end();
