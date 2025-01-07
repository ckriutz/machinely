const { app } = require('@azure/functions');

// An object of famous scientist names
const scientists = [
    'Einstein', 'Einstein', 'Einstein',
    'Newton', 'Newton', 'Newton',
    'Galileo', 'Galileo', 'Galileo',
    'Kepler', 'Kepler', 'Kepler',
    'Copernicus', 'Copernicus', 'Copernicus',
    'Hawking', 'Hawking', 'Hawking'
];

app.timer('FunTimer', {
    schedule: '0 */1 * * * *',
    handler: (myTimer, context) => {
        // Get a random scientist name
        const scientist = scientists[Math.floor(Math.random() * scientists.length)];
        context.log(`The scientist of the minute is ${scientist}`);
    }
});
